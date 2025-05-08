package org.solidstate.facturen.entities;

import java.math.BigDecimal;
import java.math.RoundingMode; // Aseguramos la importación de RoundingMode
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import org.solidstate.facturen.utils.IvaUtil;
import org.solidstate.utils.DateUtils;

@Entity
@NamedQueries({
        @NamedQuery(name = "getDocumentoDeVentaAll", query = "SELECT c FROM DocumentoDeVenta c WHERE c.periodoFiscal = :periodoFiscal AND c.totalFactura > 0 ORDER BY c.fechaFactura,c.numeroFactura , c.persona.razonSocial")
})
public class DocumentoDeVenta extends Factura {

    private Long situacionImpositiva;
    private String situacionImpositivaString;
    private Long concepto;
    @Column(precision = 12, scale = 2)
    private BigDecimal alicuotaDGR;
    @Column(precision = 12, scale = 2)
    private BigDecimal alicuotaTasaHigiene;
    @Column(precision = 12, scale = 2)
    private BigDecimal montoAlicuotaDGR;
    @Column(precision = 12, scale = 2)
    private BigDecimal montoAlicuotaTasaHigiene;

    // Si no hay un constructor explícito, Java provee uno por defecto que llama a
    // super().
    // public DocumentoDeVenta() {
    // super();
    // }

    @Override
    public void setFechaFactura(Date fechaFactura) {
        super.setFechaFactura(fechaFactura);
        setPeriodoFiscal(DateUtils.getPeriodoFromFecha(fechaFactura));
    }

    public Long getSituacionImpositiva() {
        return this.situacionImpositiva;
    }

    public void setSituacionImpositiva(Long situacionImpositiva) {
        this.situacionImpositiva = situacionImpositiva;
        setSituacionImpositivaString(IvaUtil.getSIString(situacionImpositiva));
    }

    public BigDecimal getMontoAlicuotaDGR() {
        if (this.montoAlicuotaDGR == null) {
            return null;
        }
        return this.montoAlicuotaDGR.setScale(2, RoundingMode.CEILING);
    }

    public void setMontoAlicuotaDGR(BigDecimal montoAlicuotaDGR) { // El parámetro era alicuotaDGR, lo corregí a
                                                                   // montoAlicuotaDGR por convención
        this.montoAlicuotaDGR = montoAlicuotaDGR;
    }

    public BigDecimal getMontoAlicuotaTasaHigiene() {
        if (this.montoAlicuotaTasaHigiene == null) {
            return null;
        }
        return this.montoAlicuotaTasaHigiene.setScale(2, RoundingMode.CEILING);
    }

    public void setMontoAlicuotaTasaHigiene(BigDecimal montoAlicuotaTasaHigiene) { // El parámetro era
                                                                                   // alicuotaTasaHigiene, lo corregí
                                                                                   // por convención
        this.montoAlicuotaTasaHigiene = montoAlicuotaTasaHigiene;
    }

    public Long getConcepto() {
        return this.concepto;
    }

    public void setConcepto(Long concepto) {
        this.concepto = concepto;
    }

    public BigDecimal getAlicuotaDGR() {
        if (this.alicuotaDGR == null) {
            return null;
        }
        return this.alicuotaDGR.setScale(2, RoundingMode.CEILING);
    }

    public void setAlicuotaDGR(BigDecimal alicuotaDGR) {
        this.alicuotaDGR = alicuotaDGR;
    }

    public BigDecimal getAlicuotaTasaHigiene() {
        if (this.alicuotaTasaHigiene == null) {
            return null;
        }
        return this.alicuotaTasaHigiene.setScale(2, RoundingMode.CEILING);
    }

    public void setAlicuotaTasaHigiene(BigDecimal alicuotaTasaHigiene) {
        this.alicuotaTasaHigiene = alicuotaTasaHigiene;
    }

    public String getSituacionImpositivaString() {
        return this.situacionImpositivaString;
    }

    public void setSituacionImpositivaString(String situacionImpositivaString) {
        this.situacionImpositivaString = situacionImpositivaString;
    }

    @Override
    public void invertirMontos() {
        if (this.alicuotaDGR != null) {
            this.alicuotaDGR = this.alicuotaDGR.negate();
        }

        if (this.alicuotaTasaHigiene != null) {
            this.alicuotaTasaHigiene = this.alicuotaTasaHigiene.negate();
        }

        if (this.montoAlicuotaDGR != null) {
            this.montoAlicuotaDGR = this.montoAlicuotaDGR.negate();
        }

        if (this.montoAlicuotaTasaHigiene != null) {
            this.montoAlicuotaTasaHigiene = this.montoAlicuotaTasaHigiene.negate();
        }
        super.invertirMontos();
    }
}