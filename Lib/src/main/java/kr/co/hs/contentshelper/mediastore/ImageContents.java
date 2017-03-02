package kr.co.hs.contentshelper.mediastore;

import android.database.Cursor;
import android.provider.MediaStore;

/**
 * 생성된 시간 2017-03-02, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsContentsHelper
 * 패키지명 : kr.co.hs.contentshelper.mediastore
 */

public class ImageContents extends MediaContents {
    long mTakenDate = 0;

    public ImageContents(Cursor cursor) {
        super(
                cursor.getLong(cursor.getColumnIndex(MediaStore.Images.ImageColumns._ID)),
                cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)),
                cursor.getLong(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATE_ADDED)),
                cursor.getLong(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATE_MODIFIED))
                );
        this.mTakenDate = cursor.getLong(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATE_TAKEN));

    }

    public ImageContents(long id) {
        super(id);
    }

    public ImageContents(long id, String dataPath, long addedDate, long modifiedDate, long takenDate) {
        super(id, dataPath, addedDate, modifiedDate);
        this.mTakenDate = takenDate;
    }

    public long getTakenDate() {
        return mTakenDate;
    }
}
