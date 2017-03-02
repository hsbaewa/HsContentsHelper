package kr.co.hs.contentshelper.mediastore;

/**
 * 생성된 시간 2017-03-02, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsContentsHelper
 * 패키지명 : kr.co.hs.contentshelper.mediastore
 */

public class AudioContents extends MediaContents {
    private long mAlbumId;

    public AudioContents(long id) {
        super(id);
    }

    public AudioContents(long id, String dataPath, long addedDate, long modifiedDate, long albumId) {
        super(id, dataPath, addedDate, modifiedDate);
        mAlbumId = albumId;
    }

    public long getAlbumId() {
        return mAlbumId;
    }
}
