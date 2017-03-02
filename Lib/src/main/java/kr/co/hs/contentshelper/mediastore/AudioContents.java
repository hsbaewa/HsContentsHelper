package kr.co.hs.contentshelper.mediastore;

import android.database.Cursor;
import android.provider.MediaStore;

/**
 * 생성된 시간 2017-03-02, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsContentsHelper
 * 패키지명 : kr.co.hs.contentshelper.mediastore
 */

public class AudioContents extends MediaContents {
    private long mAlbumId;

    public AudioContents(Cursor cursor) {
        super(
                cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media._ID)),
                cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA)),
                cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DATE_ADDED)),
                cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DATE_MODIFIED))
        );
        this.mAlbumId = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID));
    }

    public AudioContents(long id) {
        super(id);
    }

    public AudioContents(long id, String dataPath, long addedDate, long modifiedDate, long albumId) {
        super(id, dataPath, addedDate, modifiedDate);
        this.mAlbumId = albumId;
    }

    public long getAlbumId() {
        return mAlbumId;
    }
}
