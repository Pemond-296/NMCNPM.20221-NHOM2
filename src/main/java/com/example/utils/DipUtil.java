package com.example.utils;

import com.example.model.EventGiftModel;
import com.example.model.UserModel;

public class DipUtil {
    private static DipUtil dipUtil = null;
    private EventGiftModel data = null;

    public static DipUtil getInstance() {
        if (dipUtil == null) dipUtil = new DipUtil();

        return dipUtil;
    }

    public EventGiftModel getData() {
        return data;
    }

    public void setData(EventGiftModel data) {
        this.data = data;
    }

    public void removeData() {
        setData(null);
    }
}
