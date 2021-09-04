package music.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="product")
public class Product implements Serializable {
	
	private static final long serialVersionUID = -3532377236419238983L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    @NotEmpty (message = "The product name must not be null.")

    private String productName;
    private String productCategory;
    private String productDescription;

    @Min(value = 0, message = "The product price must no be less then zero.")
    private double productPrice;
    private String productCondition;
    private String productStatus;

    @Min(value = 0, message = "The product unit must not be less than zero.")
    private int unitInStock;
    private String productManufacturer;

    @Transient
    private MultipartFile productImage;
    
    @Transient
    private MultipartFile productAudio;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CartItem> cartItemList;


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductCategory() {
		return productCategory;
	}


	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	public String getProductCondition() {
		return productCondition;
	}


	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}


	public String getProductStatus() {
		return productStatus;
	}


	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}


	public int getUnitInStock() {
		return unitInStock;
	}


	public void setUnitInStock(int unitInStock) {
		this.unitInStock = unitInStock;
	}


	public String getProductManufacturer() {
		return productManufacturer;
	}


	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}


	public MultipartFile getProductImage() {
		return productImage;
	}


	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}


	public List<CartItem> getCartItemList() {
		return cartItemList;
	}


	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}


	public MultipartFile getProductAudio() {
		return productAudio;
	}


	public void setProductAudio(MultipartFile productAudio) {
		this.productAudio = productAudio;
	}
	
	

}
