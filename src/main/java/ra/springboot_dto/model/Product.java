package ra.springboot_dto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "Product")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    @Id
    @Column(name = "product_id")
    private String id;
    @Column(name = "product_name",unique = true,nullable = false)
    private String name;
    private float price;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;
    private String descriptions;
    @Column(name = "product_status")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "catalog_id",referencedColumnName = "catalog_id")
    private Categories catalog;
}
