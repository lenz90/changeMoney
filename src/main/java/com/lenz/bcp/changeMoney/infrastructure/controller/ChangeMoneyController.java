package com.lenz.bcp.changeMoney.infrastructure.controller;

import com.lenz.bcp.changeMoney.application.ChangeMoneyService;
import io.reactivex.Single;
import io.swagger.annotations.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/change-money/v1")
@Api(value = "Api realizar los cambios de moneda", tags = "ApiChangeMoney")
public class ChangeMoneyController {

    private ChangeMoneyService changeMoneyService;

    public ChangeMoneyController(ChangeMoneyService changeMoneyService) {
        this.changeMoneyService = changeMoneyService;
    }

    @GetMapping(value = "/change", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Obtiene el cambio de la moneda",
            response = ResponseChange.class)
    public Single<ResponseChange> getChangeMoney(@ApiParam @RequestBody RequestChange requestChanges) {
        return changeMoneyService.getChangeMoney
                (requestChanges.getAmount(), requestChanges.getOriginMoney(), requestChanges.getDestinationMoney())
                .map(x->new ResponseChange(x.originMoney(),x.destinationMoney(),x.amount(),x.amountChanged(),x.changeType()));
    }

    @PostMapping(value = "/save-type", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Guarda un tipo de cambio",
            response = ResponseChange.class)
    public void getChangeMoney(@ApiParam @RequestBody RequestChangeType requestChangeType) throws Exception {
        changeMoneyService.saveNewType(requestChangeType.getMoney(),requestChangeType.getChangeType());
    }
}

@Getter
@Setter
@ApiModel("RequestChange")
final class RequestChange {

    @ApiModelProperty(value = "Moneda origen", example = "PEN")
    @NotEmpty
    private String originMoney;

    @ApiModelProperty(value = "Moneda destino", example = "USD")
    @NotEmpty
    private String destinationMoney;

    @ApiModelProperty(value = "Monto a cambiar ", example = "10.00")
    @NotEmpty
    private Double amount;

}


@Getter
@Setter
@ApiModel("RequestChangeType")
final class RequestChangeType {

    @ApiModelProperty(value = "Moneda origen", example = "PEN")
    @NotEmpty
    private String money;

    @ApiModelProperty(value = "Valor referente a un dolar ", example = "10.00")
    @NotEmpty
    private Double changeType;

}



@Getter
@Setter
@ApiModel("ResponseChange")
final class ResponseChange {

    @ApiModelProperty(value = "Moneda origen", example = "PEN")
    @NotEmpty
    private String originMoney;

    @ApiModelProperty(value = "Moneda destino", example = "USD")
    @NotEmpty
    private String destinationMoney;

    @ApiModelProperty(value = "Monto a cambiar ", example = "10.00")
    @NotNull
    private Double amount;

    @ApiModelProperty(value = "Monto cambiado ", example = "10.00")
    @NotEmpty
    private Double amountChanged;

    @ApiModelProperty(value = "Tipo de cambio", example = "3.60")
    @NotEmpty
    private Double changeType;

    public ResponseChange(@NotEmpty String originMoney, @NotEmpty String destinationMoney, @NotNull Double amount, @NotEmpty Double amountChanged, @NotEmpty Double changeType) {
        this.originMoney = originMoney;
        this.destinationMoney = destinationMoney;
        this.amount = amount;
        this.amountChanged = amountChanged;
        this.changeType = changeType;
    }
}