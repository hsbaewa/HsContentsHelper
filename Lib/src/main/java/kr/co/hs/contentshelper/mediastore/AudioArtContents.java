package kr.co.hs.contentshelper.mediastore;

import android.database.Cursor;
import android.provider.MediaStore;

/**
 * 생성된 시간 2017-03-02, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsContentsHelper
 * 패키지명 : kr.co.hs.contentshelper.mediastore
 */

public class AudioArtContents extends ThumbnailContents {
    public AudioArtContents(Cursor cursor) {
        super(cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Albums._ID)), cursor.getString(cursor.getColumnIndex(MediaStore.Audio.AlbumColumns.ALBUM_ART)));
    }

    public AudioArtContents(long id) {
        super(id);
    }

    public AudioArtContents(long id, String path) {
        super(id, path);
    }
}
