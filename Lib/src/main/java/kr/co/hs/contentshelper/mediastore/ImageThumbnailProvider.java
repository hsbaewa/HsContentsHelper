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

public class ImageThumbnailProvider extends ThumbnailProvider<ImageThumbnailContents> {
    public ImageThumbnailProvider(Context context, int mode) {
        super(context, mode);
    }

    @Override
    public Uri getExternalUri() {
        return MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI;
    }

    @Override
    public Uri getInternalUri() {
        return MediaStore.Images.Thumbnails.INTERNAL_CONTENT_URI;
    }

    @Override
    public String getData(long id) {
        Cursor cursor = getContentsCursor(null, MediaStore.Images.Thumbnails._ID+"=?", new String[]{String.valueOf(id)}, null);
        try{
            if(cursor == null || !cursor.moveToFirst())
                return null;
            String data = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Thumbnails.DATA));
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

    public String getDataFromImageId(long imageId){
        Cursor cursor = getContentsCursor(null, MediaStore.Images.Thumbnails.IMAGE_ID+"=?", new String[]{String.valueOf(imageId)}, null);
        try{
            if(cursor == null || !cursor.moveToFirst())
                return null;
            String data = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Thumbnails.DATA));
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
                long id = cursor.getLong(cursor.getColumnIndex(MediaStore.Images.Thumbnails._ID));
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
    public ImageThumbnailContents[] getContents(String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor = getContentsCursor(projection, selection, selectionArgs, sortOrder);

        try{
            if(cursor == null)
                return null;

            ImageThumbnailContents[] result = new ImageThumbnailContents[cursor.getCount()];
            for(int i=0;i<result.length;i++){
                cursor.moveToPosition(i);
                result[i] = new ImageThumbnailContents(cursor);
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
    public ImageThumbnailContents getContent(long id) {
        Cursor cursor = getContentsCursor(null, MediaStore.Images.Thumbnails._ID, new String[]{String.valueOf(id)}, null);

        try{
            if(cursor == null || !cursor.moveToFirst())
                return null;

            return new ImageThumbnailContents(cursor);
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
    public ImageThumbnailContents getThumbnailFromMediaId(long imageId) {
        Cursor cursor = getContentsCursor(null, MediaStore.Images.Thumbnails.IMAGE_ID+"=?", new String[]{String.valueOf(imageId)}, null);

        try{
            if(cursor == null || !cursor.moveToFirst())
                return null;

            return new ImageThumbnailContents(cursor);
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
