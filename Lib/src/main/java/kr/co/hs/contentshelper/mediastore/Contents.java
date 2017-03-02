package kr.co.hs.contentshelper.mediastore;

/**
 * 생성된 시간 2017-03-02, Bae 에 의해 생성됨
 * 프로젝트 이름 : HsContentsHelper
 * 패키지명 : kr.co.hs.contentshelper.mediastore
 */

class Contents {
    private long mId;
    private String mDataPath;

    public Contents(long id) {
        mId = id;
    }

    public Contents(long id, String dataPath) {
        mId = id;
        mDataPath = dataPath;
    }

    public long getId() {
        return mId;
    }

    public String getDataPath() {
        return mDataPath;
    }
}
