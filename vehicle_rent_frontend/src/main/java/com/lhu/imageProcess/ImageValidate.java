package com.lhu.imageProcess;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.lhu.vehicle_rent_backend.DTO.User;


public class ImageValidate implements Validator {
	private static final Log log = LogFactory.getLog(ImageValidate.class);
	@Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    	log.debug("Enter | validate");
    	User user = (User) target;
        if(user.getFile() == null || user.getFile().getOriginalFilename().equals("")) {
            errors.rejectValue("file", null, "Please select a file to upload!");
            return;
        }
        if(! (user.getFile().getContentType().equals("image/jpeg") || 
        		user.getFile().getContentType().equals("image/png")) ||
        		user.getFile().getContentType().equals("image/gif")
             )
            {
                errors.rejectValue("file", null, "Please select an image file to upload!");
                return; 
            }

    }

}
