package com.lhu.imageProcess;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.web.multipart.MultipartFile;


public class ImageUpload {
	private static final Log log = LogFactory.getLog(ImageUpload.class);
	private static String ABS_PATH = null;
    private static String REAL_PATH = null;
    
    public static boolean uploadFile(HttpServletRequest request, MultipartFile file, String code,int type) 
    {   log.debug("Enter | uploadFile");
    	if(type == 0){
    		ABS_PATH = "C:/Users/LHU/git/vehicle-rent/vehicle_rent_frontend/src/main/webapp/assets/images/userImage/";
            REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/userImage/");
    	}else{
    		ABS_PATH = "C:/Users/LHU/git/vehicle-rent/vehicle_rent_frontend/src/main/webapp/assets/images/vehicleImage/";
            REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/vehicleImage/");
    	}
    	log.debug("Info | ABS_PATH : "+ABS_PATH);
    	log.debug("Info | REAL_PATH : "+REAL_PATH);
        // create the directories if it does not exist        
        if(!new File(REAL_PATH).exists()) {
            new File(REAL_PATH).mkdirs();
        }
        
        if(!new File(ABS_PATH).exists()) {
            new File(ABS_PATH).mkdirs();
        }
        
        try {
            //transfer the file to both the location
            file.transferTo(new File(REAL_PATH + code + ".jpg"));
            file.transferTo(new File(ABS_PATH + code + ".jpg"));
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        return true;
    }
    
    public static void uploadNoImage(HttpServletRequest request, String code) {
        // get the real server path
        REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
    
        String imageURL = "http://placehold.it/640X480?text=No Image";
        String destinationServerFile = REAL_PATH + code + ".jpg";
        String destinationProjectFile = REAL_PATH + code + ".jpg";
                
        try {
            URL url = new URL(imageURL);                
            try (   
                    InputStream is = url.openStream();
                    OutputStream osREAL_PATH = new FileOutputStream(destinationServerFile);
                    OutputStream osABS_PATH = new FileOutputStream(destinationProjectFile);
                ){
            
                byte[] b = new byte[2048];
                int length;
                while((length = is.read(b))!= -1) {
                    osREAL_PATH.write(b, 0, length);
                    osABS_PATH.write(b, 0, length);
                }
            }           
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}
