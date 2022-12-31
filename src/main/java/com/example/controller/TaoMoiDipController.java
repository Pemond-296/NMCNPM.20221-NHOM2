package com.example.controller;


        import com.example.model.EventGiftModel;
        import com.example.model.MinhChungModel;
        import com.example.model.PersonModel;
        import com.example.model.TraoThuongModel;
        import com.example.service.IEventGiftService;
        import com.example.service.IMinhChungService;
        import com.example.service.IPersonService;
        import com.example.service.impl.EventGiftService;
        import com.example.service.impl.MinhChungService;
        import com.example.service.impl.PersonService;
        import com.example.utils.DateUtil;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.Node;
        import javafx.scene.control.Button;
        import javafx.scene.control.DatePicker;
    import javafx.scene.control.TextField;
        import javafx.stage.Stage;

        import java.util.Calendar;
        import java.util.Date;
        import java.util.List;

public class TaoMoiDipController {
    private IEventGiftService eventGiftService = new EventGiftService();
    private IPersonService personService = new PersonService();
    private IMinhChungService minhChungService = new MinhChungService();
    @FXML
    private DatePicker Date;

    @FXML
    private TextField DoiTuongNhanF;

    @FXML
    private TextField TenQuaF;

    @FXML
    private Button taoMoiB;

    @FXML
    private TextField tenDipT;

    @FXML
    public void TaoMoiE(ActionEvent event) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        EventGiftModel eventGiftModel = new EventGiftModel();
        eventGiftModel.setNameEvent(tenDipT.getText());
        eventGiftModel.setDate(DateUtil.asDate(Date.getValue()));
        eventGiftModel.setTen_phan_thuong(TenQuaF.getText());
        eventGiftModel.setTen_doi_tuong(DoiTuongNhanF.getText());

        Long id = eventGiftService.save(eventGiftModel);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();

    }

}
