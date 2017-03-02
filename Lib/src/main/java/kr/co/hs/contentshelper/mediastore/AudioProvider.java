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

public class AudioProvider extends Provider<AudioContents> {
    public AudioProvider(Context context, int mode) {
        super(context, mode);
    }

    @Override
    public Uri getExternalUri() {
        return MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    }

    @Override
    public Uri getInternalUri() {
        return MediaStore.Audio.Media.INTERNAL_CONTENT_URI;
    }

    @Override
    public String getData(long id) {
        Cursor cursor = getContentsCursor(null, MediaStore.Audio.AudioColumns._ID+"=?", new String[]{String.valueOf(id)}, null);
        try{
            if(cursor == null || !cursor.moveToFirst())
                return null;
            String data = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DATA));
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

    public String getThumbnail(long id){
        Cursor cursor = getContentsCursor(null, MediaStore.Audio.AudioColumns._ID+"=?", new String[]{String.valueOf(id)}, null);
        try{
            if(cursor == null || !cursor.moveToFirst())
                return null;
            long albumId = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.ALBUM_ID));
            AudioArtProvider audioArtProvider = new AudioArtProvider(getContext(), getMode());
            String art = audioArtProvider.getDataFromAlbumId(albumId);
            return art;
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
                long id = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.AudioColumns._ID));
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
    public AudioContents[] getContents(String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor = getContentsCursor(projection, selection, selectionArgs, sortOrder);

        try{
            if(cursor == null)
                return null;

            AudioContents[] result = new AudioContents[cursor.getCount()];
            for(int i=0;i<result.length;i++){
                cursor.moveToPosition(i);
                long id = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.AudioColumns._ID));
                String dataPath = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                long addedDate = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DATE_ADDED));
                long modDate = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DATE_MODIFIED));
                long albumId = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID));
                result[i] = new AudioContents(id, dataPath, addedDate, modDate, albumId);
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
    public AudioContents getContent(long id) {
        Cursor cursor = getContentsCursor(null, MediaStore.Audio.AudioColumns._ID+"=?", new String[]{String.valueOf(id)}, null);
        try{
            if(cursor == null || !cursor.moveToFirst())
                return null;

            String dataPath = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
            long addedDate = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DATE_ADDED));
            long modDate = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DATE_MODIFIED));
            long albumId = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID));
            return new AudioContents(id, dataPath, addedDate, modDate, albumId);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if(cursor != null && !cursor.isClosed()){
                cursor.close();
            }
        }
    }
}
