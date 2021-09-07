package model.DAO;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.DTO.ProductDTO;
import model.DTO.ProductDTO.Get;
import model.domain.Product;
import util.DBUtil;

public class ProductDAO {
	
	private static ProductDAO instance = new ProductDAO();
	
	private ProductDAO() {}

	public static ProductDAO getInstance() {
		return instance;
	}
	
	/** 제품 다중(전체) 조회 >> 지수
	 * 
	 */
	public ArrayList<ProductDTO.Get> getAllProducts() {
		EntityManager em =  DBUtil.getEntityManager();
		ArrayList<ProductDTO.Get> all = null;
		
		try {
			all = (ArrayList<ProductDTO.Get>)em.createNativeQuery("SELECT * FROM product", Product.class).getResultList();
		} catch(Exception e) {
			//e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
		
		return all;
	}
	
	/** 제품 이름으로 단일 조회 >> 지수
	 * 
	 */
	public ArrayList<ProductDTO.Get> getProduct(String name) {
		EntityManager em = DBUtil.getEntityManager();
		ArrayList<ProductDTO.Get> nAll = null;
		
		try {
			Query query = em.createNativeQuery("SELECT * FROM product WHERE product_name=?", Product.class);
			query.setParameter(1, name);
			nAll = (ArrayList<ProductDTO.Get>)query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
		
		return nAll;
	}
	
	/** 제품 카테고리별로 조회 >> 지수
	 * 
	 */
	public ArrayList<ProductDTO.Get> getCategoryProduct(String category) {
		EntityManager em = DBUtil.getEntityManager();
		ArrayList<ProductDTO.Get> cAll = null;
		
		try {
			Query query = em.createNativeQuery("SELECT * FROM product WHERE category=?", Product.class);
			query.setParameter(1, category);
			cAll = (ArrayList<ProductDTO.Get>)query.getResultList();
		} catch(Exception e) {
			//e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
		
		return cAll;
	}
	
	/** 제품 추가 >> 한나
	 * 
	 */
	
	/** 제품 수정 ** request, update 나눠서(보류)
	 * 
	 */
	
	/** 제품 삭제 >> 한나
	 * 
	 */
}