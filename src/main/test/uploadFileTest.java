import com.wtu.jht.bookmanage.openapi.PropertiesUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;

/**
 * @date ：Created in 2019/5/16 13:16
 * @description：
 * @modified By：
 * @version: $
 */

@Component
public class uploadFileTest {

    private String uploadFolder = PropertiesUtil.getProperty("file.uploadFolder");
    @Test
    public void edit() {
        System.out.println(uploadFolder);
    }

}