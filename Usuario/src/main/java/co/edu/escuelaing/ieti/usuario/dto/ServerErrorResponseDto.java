package co.edu.escuelaing.ieti.usuario.dto;

import co.edu.escuelaing.ieti.usuario.controller.auth.ErrorCodeEnum;

public class ServerErrorResponseDto {

    String mesage;
    ErrorCodeEnum errorCodeEnum;
    int httpStatus;

    public ServerErrorResponseDto(String mesage, ErrorCodeEnum errorCodeEnum, int httpStatus) {
        this.mesage = mesage;
        this.errorCodeEnum = errorCodeEnum;
        this.httpStatus = httpStatus;
    }

    public String getMesage() {
        return mesage;
    }

    public void setMesage(String mesage) {
        this.mesage = mesage;
    }

    public ErrorCodeEnum getErrorCodeEnum() {
        return errorCodeEnum;
    }

    public void setErrorCodeEnum(ErrorCodeEnum errorCodeEnum) {
        this.errorCodeEnum = errorCodeEnum;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }
}
