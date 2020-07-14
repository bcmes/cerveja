package github.com.brunomeloesilva.cervejas.repository.paginacao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class PaginacaoUtil {
	
	public void preparar(Criteria criteria, Pageable pageable) {
		int firstResult = pageable.getPageNumber();
		int maxResults = pageable.getPageSize();
		firstResult = firstResult * maxResults; 
		criteria.setFirstResult(firstResult);
		criteria.setMaxResults(maxResults);
		
		Sort sort = pageable.getSort();
		if( sort != null ) {
			Sort.Order order = sort.iterator().next();
			String field = order.getProperty();
			criteria.addOrder(order.isAscending() ? Order.asc(field) : Order.desc(field));
		}
	}
}
