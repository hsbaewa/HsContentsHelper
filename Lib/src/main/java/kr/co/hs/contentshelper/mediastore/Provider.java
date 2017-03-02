package kr.co.hs.contentshelper.mediastore;


import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/**
 * 생성된 시간 2017-03-02, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsContentsHelper
 * 패키지명 : kr.co.hs.contentshelper
 */

abstract class Provider<C extends Contents> {
    public static final int MODE_INTERNAL = 100;
    public static final int MODE_EXTERNAL = 200;

    private Context mContext;
    private int mMode;

    public Provider(Context context, int mode) {
        mContext = context;
        mMode = mode;
    }

    public Context getContext() {
        return mContext;
    }

    public int getMode(){
        return this.mMode;
    }

    public int getContentsCount() {
        return getContentsCount(null, null, null, null);
    }

    public int getContentsCount(String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor = getContentsCursor(projection, selection, selectionArgs, sortOrder);
        try{
            if(cursor == null)
                return 0;
            return cursor.getCount();
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            if(cursor != null && !cursor.isClosed()){
                cursor.close();
            }
        }
    }

    public Cursor getContentsCursor(String[] projection, String selection, String[] selectionArgs, String sortOrder){
        Cursor cursor = null;
        if(getMode() == MODE_INTERNAL)
            cursor = getContext().getContentResolver().query(getInternalUri(), projection, selection, selectionArgs, sortOrder);
        else if(getMode() == MODE_EXTERNAL)
            cursor = getContext().getContentResolver().query(getExternalUri(), projection, selection, selectionArgs, sortOrder);
        return cursor;
    }
    public Cursor getContentsCursor(){
        return getContentsCursor(null, null, null, null);
    }


    public long[] getIDs(){
        return getIDs(null, null, null, null);
    }

    public C[] getContents(){
        return getContents(null, null, null, null);
    }


    public abstract Uri getExternalUri();
    public abstract Uri getInternalUri();
    public abstract String getData(long id);
    public abstract long[] getIDs(String[] projection, String selection, String[] selectionArgs, String sortOrder);
    public abstract C[] getContents(String[] projection, String selection, String[] selectionArgs, String sortOrder);
    public abstract C getContent(long id);
}
