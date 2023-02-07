package com.example.utils;

import com.example.model.MinhChungModel;

public class MinhChungUtil {
    private static MinhChungUtil minhChungUtil = null;
    private MinhChungModel data = null;

    public static MinhChungUtil getInstance() {
        if (minhChungUtil == null) minhChungUtil = new MinhChungUtil();

        return minhChungUtil;
    }

    public MinhChungModel getData() {
        return data;
    }

    public void setData(MinhChungModel data) {
        this.data = data;
    }

    public void removeData() {
        setData(null);
    }
}
