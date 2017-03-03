package kr.co.hs.contentshelper.mediastore;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/**
 * 생성된 시간 2017-03-02, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsContentsHelper
 * 패키지명 : kr.co.hs.contentshelper.mediastore
 */

public abstract class ProviderCursor<C extends Contents> {
    private Context mContext;
    private Cursor mCursor;

    public ProviderCursor(Context context, Uri uri) {
        this.mContext = context;
        mCursor = getContext().getContentResolver().query(uri, null,null,null,null);
    }

    public ProviderCursor(Context context, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        this.mContext = context;
        mCursor = getContext().getContentResolver().query(uri, projection, selection, selectionArgs, sortOrder);
    }

    public Context getContext() {
        return mContext;
    }

    public void close(){
        if(mCursor != null && !mCursor.isClosed()){
            mCursor.close();
        }
    }

    public int getCount(){
        return mCursor.getCount();
    }

    public Cursor getCursor() {
        return mCursor;
    }

    public abstract C getContent(int position);
}
