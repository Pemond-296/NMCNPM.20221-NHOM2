
package com.example.service;

import com.example.model.EventGiftModel;
import com.example.model.ThongKeModel;

import java.util.List;

public interface IThongKeService {
    public List<ThongKeModel> findByDip(EventGiftModel e);
}