package com.projarc.clean.application.dto;

import java.sql.Date;

public class AssinaturaPatchDTO {

    private Date dataFim;

    public AssinaturaPatchDTO() {
    }

    public AssinaturaPatchDTO(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public String toString() {
        return "AssinaturaPatchDTO [dataFim=" + dataFim + "]";
    }

}
