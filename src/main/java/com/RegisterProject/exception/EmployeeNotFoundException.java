package com.RegisterProject.exception;

public class EmployeeNotFoundException  extends Exception{

        private String message;
        private String statusCode;

        public EmployeeNotFoundException(String message1, String statusCode) {
//        super(message);
            this.message = message1;
            this.statusCode = statusCode;
        }

        @Override
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }


}
