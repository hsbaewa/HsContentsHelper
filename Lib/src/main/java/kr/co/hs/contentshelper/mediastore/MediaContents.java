package kr.co.hs.contentshelper.mediastore;


/**
 * 생성된 시간 2017-03-02, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsContentsHelper
 * 패키지명 : kr.co.hs.contentshelper.mediastore
 */

class MediaContents extends Contents {
    private long mAddedDate;
    private long mModifiedDate;

    public MediaContents(long id) {
        super(id);
    }

    public MediaContents(long id, String dataPath, long addedDate, long modifiedDate) {
        super(id, dataPath);
        this.mAddedDate = addedDate;
        this.mModifiedDate = modifiedDate;
    }

    public long getAddedDate() {
        return mAddedDate;
    }

    public long getModifiedDate() {
        return mModifiedDate;
    }
}
