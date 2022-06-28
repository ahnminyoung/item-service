package bye.itemservice.web.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Service
public class FileService {

    @Value("${local.dir}")
    private String UPLOAD_PATH;

    public void fileUpload(MultipartFile file) throws IOException{

        File fileFolder = new File(UPLOAD_PATH);
        //업로드 폴더 확인 없으면 생성
        if (!fileFolder.exists()) {
            fileFolder.mkdirs();
        }

        File dest = new File(UPLOAD_PATH + file.getOriginalFilename());
        file.transferTo(dest);

    }

    /**
     * 파일 다운로드
     * @Param request HttpServletRequest
     * @Param Response HttpServletResponse
     */
    public void fileDownload(HttpServletResponse response) throws IOException{
        System.out.println("response11 = " + response);
        File file = new File(UPLOAD_PATH);
        int fileLength = (int) file.length();
        if(fileLength > 0){
            response.setHeader("Content-Disposition", "attachment; filename=\"" + "aa" + "\";");
            response.setHeader("content-Transfer-Encoding", "binary");
            response.setHeader("content-Length", ""+fileLength);
            response.setHeader("Pragma", "no-cache;");
            response.setHeader("Expires", "-1;");

            FileInputStream fis = new FileInputStream(UPLOAD_PATH);
            OutputStream out = response.getOutputStream();

            int readCount = 0;
            byte[] buffer = new byte[1024];
            while ((readCount = fis.read(buffer)) != -1) {
                out.write(buffer, 0, readCount);
            }
        }
    }

}
