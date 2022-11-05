package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(name = "Ma")
    private String ma;
    
    @Column(name = "TEN")
    private String ten;
    
    @Column(name = "SOLUONG")
    private int soluong;
    
    @Column(name = "Dongia")
    private BigDecimal dongia;
    
    @ManyToOne
    @JoinColumn(name = "ID_CATE",nullable = false)
    private Category category;
}
