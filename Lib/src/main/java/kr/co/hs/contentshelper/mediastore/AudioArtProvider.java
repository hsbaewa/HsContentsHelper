package kr.co.hs.contentshelper.mediastore;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

/**
 * 생성된 시간 2017-03-02, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsContentsHelper
 * 패키지명 : kr.co.hs.contentshelper.mediastore
 */

public class AudioArtProvider extends ThumbnailProvider<AudioArtContents>{
    public AudioArtProvider(Context context, int mode) {
        super(context, mode);
    }

    @Override
    public Uri getExternalUri() {
        return MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI;
    }

    @Override
    public Uri getInternalUri() {
        return MediaStore.Audio.Albums.INTERNAL_CONTENT_URI;
    }

    @Override
    public String getData(long id) {
        Cursor cursor = getContentsCursor(null, MediaStore.Audio.Albums._ID+"=?", new String[]{String.valueOf(id)}, null);
        try{
            if(cursor == null || !cursor.moveToFirst())
                return null;
            String data = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.AlbumColumns.ALBUM_ART));
            return data;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if(cursor != null && !cursor.isClosed()){
                cursor.close();
            }
        }
    }

    public String getDataFromAlbumId(long albumId){
        Cursor cursor = getContentsCursor(null, MediaStore.Audio.Albums._ID+"=?", new String[]{String.valueOf(albumId)}, null);
        try{
            if(cursor == null || !cursor.moveToFirst())
                return null;
            String data = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.AlbumColumns.ALBUM_ART));
            return data;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if(cursor != null && !cursor.isClosed()){
                cursor.close();
            }
        }
    }

    @Override
    public long[] getIDs(String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor = getContentsCursor(projection, selection, selectionArgs, sortOrder);

        try{
            if(cursor == null)
                return null;

            long[] result = new long[cursor.getCount()];
            for(int i=0;i<result.length;i++){
                cursor.moveToPosition(i);
                long id = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Albums._ID));
                result[i] = id;
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if(cursor != null && !cursor.isClosed()){
                cursor.close();
            }
        }
    }

    @Override
    public AudioArtContents[] getContents(String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor = getContentsCursor(projection, selection, selectionArgs, sortOrder);
        try{
            if(cursor == null)
                return null;
            AudioArtContents[] result = new AudioArtContents[cursor.getCount()];

            for(int i=0;i<result.length;i++){
                cursor.moveToPosition(i);
                result[i] = new AudioArtContents(cursor);
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if(cursor != null && !cursor.isClosed()){
                cursor.close();
            }
        }
    }

    @Override
    public AudioArtContents getContent(long id) {
        Cursor cursor = getContentsCursor(null, MediaStore.Audio.Albums._ID+"=?", new String[]{String.valueOf(id)}, null);
        try{
            if(cursor == null || !cursor.moveToFirst())
                return null;

            return new AudioArtContents(cursor);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if(cursor != null && !cursor.isClosed()){
                cursor.close();
            }
        }
    }

    @Override
    public AudioArtContents getThumbnailFromMediaId(long albumId) {
        return getContent(albumId);
    }

}
