package model;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class ErrorMassageModel {
    @Expose
    private String message;
}
