package edu.utn.utnphones.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "calls")
public class Call {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "call_id")
    @ApiModelProperty(notes = "The database generated product ID")
    private int Id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "call_line_id_from")
    @ApiModelProperty(notes = "ID of the originating telephone line")
    private PhoneLine lineIdFrom;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "call_line_id_to")
    @ApiModelProperty(notes = "ID of the destination telephone line")
    private PhoneLine lineIdTo;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "call_invoice_id")
    @ApiModelProperty(notes = "Invoice belonging to the call")
    private Invoice invoice;

    @NotNull
    @Column(name = "call_minute_price")
    @ApiModelProperty(notes = "Price per minute of the call")
    private float minutePrice;

    @NotNull
    @Column(name = "call_duration_seg")
    @ApiModelProperty(notes = "Call duration")
    private int duration;

    @NotNull
    @Column(name = "call_date")
    @ApiModelProperty(notes = "Call date")
    private Date date;
}
