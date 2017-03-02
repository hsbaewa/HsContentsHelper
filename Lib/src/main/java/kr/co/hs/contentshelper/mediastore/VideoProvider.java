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

public class VideoProvider extends Provider<VideoContents> {

    public VideoProvider(Context context, int mode) {
        super(context, mode);
    }

    @Override
    public Uri getExternalUri() {
        return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    }

    @Override
    public Uri getInternalUri() {
        return MediaStore.Video.Media.INTERNAL_CONTENT_URI;
    }

    @Override
    public String getData(long id) {
        Cursor cursor = getContentsCursor(null, MediaStore.Video.VideoColumns._ID+"=?", new String[]{String.valueOf(id)}, null);
        try{
            if(cursor == null || !cursor.moveToFirst())
                return null;
            String data = cursor.getString(cursor.getColumnIndex(MediaStore.Video.VideoColumns.DATA));
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
        VideoThumbnailProvider videoThumbnailProvider = new VideoThumbnailProvider(getContext(), getMode());
        String thumbnail = videoThumbnailProvider.getDataFromVideoId(id);
        return thumbnail;
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
                long id = cursor.getLong(cursor.getColumnIndex(MediaStore.Video.VideoColumns._ID));
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
    public VideoContents[] getContents(String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor = getContentsCursor(projection, selection, selectionArgs, sortOrder);

        try{
            if(cursor == null)
                return null;

            VideoContents[] result = new VideoContents[cursor.getCount()];
            for(int i=0;i<result.length;i++){
                cursor.moveToPosition(i);
                long id = cursor.getLong(cursor.getColumnIndex(MediaStore.Video.VideoColumns._ID));
                String dataPath = cursor.getString(cursor.getColumnIndex(MediaStore.Video.VideoColumns.DATA));
                long addDate = cursor.getLong(cursor.getColumnIndex(MediaStore.Video.VideoColumns.DATE_ADDED));
                long modDate = cursor.getLong(cursor.getColumnIndex(MediaStore.Video.VideoColumns.DATE_MODIFIED));
                long takenDate = cursor.getLong(cursor.getColumnIndex(MediaStore.Video.VideoColumns.DATE_TAKEN));
                result[i] = new VideoContents(id, dataPath, addDate, modDate, takenDate);
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
    public VideoContents getContent(long id) {
        Cursor cursor = getContentsCursor(null, MediaStore.Video.Media._ID, new String[]{String.valueOf(id)}, null);

        try{
            if(cursor == null || !cursor.moveToFirst())
                return null;

            String dataPath = cursor.getString(cursor.getColumnIndex(MediaStore.Video.VideoColumns.DATA));
            long addDate = cursor.getLong(cursor.getColumnIndex(MediaStore.Video.VideoColumns.DATE_ADDED));
            long modDate = cursor.getLong(cursor.getColumnIndex(MediaStore.Video.VideoColumns.DATE_MODIFIED));
            long takedDate = cursor.getLong(cursor.getColumnIndex(MediaStore.Video.VideoColumns.DATE_TAKEN));

            return new VideoContents(id, dataPath, addDate, modDate, takedDate);
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
