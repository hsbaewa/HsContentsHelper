package kr.co.hs.contentshelper.mediastore;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

/**
 * 생성된 시간 2017-03-02, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsContentsHelper
 * 패키지명 : kr.co.hs.contentshelper.mediastore
 */

public class VideoThumbnailProvider extends ThumbnailProvider<VideoThumbnailContents> {
    public VideoThumbnailProvider(Context context, int mode) {
        super(context, mode);
    }

    @Override
    public Uri getExternalUri() {
        return MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI;
    }

    @Override
    public Uri getInternalUri() {
        return MediaStore.Video.Thumbnails.INTERNAL_CONTENT_URI;
    }

    @Override
    public String getData(long id) {
        Cursor cursor = getContentsCursor(null, MediaStore.Video.Thumbnails._ID+"=?", new String[]{String.valueOf(id)}, null);
        try{
            if(cursor == null || !cursor.moveToFirst())
                return null;
            String data = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Thumbnails.DATA));
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

    public String getDataFromVideoId(long videoId){
        Cursor cursor = getContentsCursor(null, MediaStore.Video.Thumbnails.VIDEO_ID+"=?", new String[]{String.valueOf(videoId)}, null);
        try{
            if(cursor == null || !cursor.moveToFirst())
                return null;
            String data = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Thumbnails.DATA));
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
                long id = cursor.getLong(cursor.getColumnIndex(MediaStore.Video.Thumbnails._ID));
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
    public VideoThumbnailContents[] getContents(String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor = getContentsCursor(projection, selection, selectionArgs, sortOrder);

        try{
            if(cursor == null)
                return null;

            VideoThumbnailContents[] result = new VideoThumbnailContents[cursor.getCount()];
            for(int i=0;i<result.length;i++){
                cursor.moveToPosition(i);
                long id = cursor.getLong(cursor.getColumnIndex(MediaStore.Video.Thumbnails._ID));
                String dataPath = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Thumbnails.DATA));
                result[i] = new VideoThumbnailContents(id, dataPath);
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
    public VideoThumbnailContents getContent(long id) {
        Cursor cursor = getContentsCursor(null, MediaStore.Video.Thumbnails._ID, new String[]{String.valueOf(id)}, null);

        try{
            if(cursor == null || !cursor.moveToFirst())
                return null;
            String dataPath = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Thumbnails.DATA));
            return new VideoThumbnailContents(id, dataPath);
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
    public VideoThumbnailContents getThumbnailFromMediaId(long videoId) {
        Cursor cursor = getContentsCursor(null, MediaStore.Video.Thumbnails.VIDEO_ID+"=?", new String[]{String.valueOf(videoId)}, null);

        try{
            if(cursor == null || !cursor.moveToFirst())
                return null;
            long id = cursor.getLong(cursor.getColumnIndex(MediaStore.Video.Thumbnails._ID));
            String dataPath = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Thumbnails.DATA));
            return new VideoThumbnailContents(id, dataPath);
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
