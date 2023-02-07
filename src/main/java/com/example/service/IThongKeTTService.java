
package com.example.service;

import com.example.model.EventGiftModel;
import com.example.model.ThongKeTTModel;

import java.util.List;

public interface IThongKeTTService {
    public List<ThongKeTTModel> findByDip(EventGiftModel e);
}