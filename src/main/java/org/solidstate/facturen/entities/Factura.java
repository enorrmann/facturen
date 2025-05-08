package org.solidstate.facturen.entities;

import java.math.BigDecimal;
import java.math.RoundingMode; // Importar RoundingMode
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "FACTURA")
@NamedQuery(name = "getFacturasByPersona", query = "SELECT f FROM Factura f where f.persona = :persona ORDER BY f.fechaFactura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private FormaDePago formaDePago;
    @Temporal(TemporalType.DATE)
    private Date fechaFactura;
    private String letraFactura;
    private String numeroFactura;
    private String periodoFiscal;
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Persona persona;
    @Column(precision = 12, scale = 2)
    private BigDecimal montoImponible;
    @Column(precision = 12, scale = 2)
    private BigDecimal iva21;
    @Column(precision = 12, scale = 2)
    private BigDecimal totalFactura;

    public Factura() {
    }

    public Factura(FormaDePago formaDePago, Date fechaFactura, String letraFactura, String numeroFactura,
            Persona persona, BigDecimal montoImponible, BigDecimal iva21, BigDecimal totalFactura,
            String periodoFiscal) {
        this.formaDePago = formaDePago;
        this.fechaFactura = fechaFactura;
        this.letraFactura = letraFactura;
        this.numeroFactura = numeroFactura;
        this.persona = persona;
        this.montoImponible = montoImponible;
        this.iva21 = iva21;
        this.totalFactura = totalFactura;
        this.periodoFiscal = periodoFiscal;
    }

    public Date getFechaFactura() {
        return this.fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public BigDecimal getIva21() {
        if (this.iva21 == null) {
            return null; // O podrías retornar BigDecimal.ZERO.setScale(2, RoundingMode.CEILING) si
                         // prefieres
        }
        return this.iva21.setScale(2, RoundingMode.CEILING);
    }

    public void setIva21(BigDecimal iva21) {
        this.iva21 = iva21;
    }

    public String getLetraFactura() {
        return this.letraFactura;
    }

    public void setLetraFactura(String letraFactura) {
        this.letraFactura = letraFactura;
    }

    public BigDecimal getMontoImponible() {
        if (this.montoImponible == null) {
            return null; // O podrías retornar BigDecimal.ZERO.setScale(2, RoundingMode.CEILING)
        }
        return this.montoImponible.setScale(2, RoundingMode.CEILING);
    }

    public void setMontoImponible(BigDecimal montoImponible) {
        this.montoImponible = montoImponible;
    }

    public Persona getPersona() {
        return this.persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public BigDecimal getTotalFactura() {
        if (this.totalFactura == null) {
            return null; // O podrías retornar BigDecimal.ZERO.setScale(2, RoundingMode.CEILING)
        }
        return this.totalFactura.setScale(2, RoundingMode.CEILING);
    }

    public void setTotalFactura(BigDecimal totaFactura) {
        this.totalFactura = totaFactura;
    }

    public FormaDePago getFormaDePago() {
        return this.formaDePago;
    }

    public void setFormaDePago(FormaDePago formaDePago) {
        this.formaDePago = formaDePago;
    }

    public String getNumeroFactura() {
        return this.numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeriodoFiscal() {
        return this.periodoFiscal;
    }

    public void setPeriodoFiscal(String periodoFiscal) {
        this.periodoFiscal = periodoFiscal;
    }

    public void invertirMontos() {
        if (this.montoImponible != null) {
            this.montoImponible = this.montoImponible.negate();
        }

        if (this.iva21 != null) {
            this.iva21 = this.iva21.negate();
        }

        if (this.totalFactura != null)
            this.totalFactura = this.totalFactura.negate();
    }
}