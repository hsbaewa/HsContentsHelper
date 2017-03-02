package kr.co.hs.contentshelper.mediastore;


import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

/**
 * 생성된 시간 2017-03-02, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsContentsHelper
 * 패키지명 : kr.co.hs.contentshelper
 */

public class ImageProvider extends Provider<ImageContents>{

    public ImageProvider(Context context, int mode) {
        super(context, mode);
    }

    @Override
    public Uri getExternalUri() {
        return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }

    @Override
    public Uri getInternalUri() {
        return MediaStore.Images.Media.INTERNAL_CONTENT_URI;
    }

    @Override
    public String getData(long id) {
        Cursor cursor = getContentsCursor(null, MediaStore.Images.ImageColumns._ID+"=?", new String[]{String.valueOf(id)}, null);
        try{
            if(cursor == null || !cursor.moveToFirst())
                return null;
            String data = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA));
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
        ImageThumbnailProvider thumbnailProvider = new ImageThumbnailProvider(getContext(), getMode());
        String thumbnail = thumbnailProvider.getDataFromImageId(id);
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
                long id = cursor.getLong(cursor.getColumnIndex(MediaStore.Images.ImageColumns._ID));
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
    public ImageContents[] getContents(String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor = getContentsCursor(projection, selection, selectionArgs, sortOrder);

        try{
            if(cursor == null)
                return null;

            ImageContents[] result = new ImageContents[cursor.getCount()];
            for(int i=0;i<result.length;i++){
                cursor.moveToPosition(i);
                result[i] = new ImageContents(cursor);
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
    public ImageContents getContent(long id) {
        Cursor cursor = getContentsCursor(null, MediaStore.Images.Media._ID, new String[]{String.valueOf(id)}, null);

        try{
            if(cursor == null || !cursor.moveToFirst())
                return null;
            return new ImageContents(cursor);
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
