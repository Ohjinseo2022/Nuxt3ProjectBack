package ojs.blog.ojs_back.service.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ojs.blog.ojs_back.domain.UserMaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class UserMasterSpecification {

    private final Logger log = LoggerFactory.getLogger(UserMasterSpecification.class);

    @Getter
    @AllArgsConstructor
    public enum UserMasterSearchKey {
        userName("사용자이름")
        ;

        private final String value;
    }

    public static Specification<UserMaster> searchWith(Map<UserMasterSearchKey, Object> searchKeyword) {
        return (root, query, builder) -> {
            List<Predicate> predicate = getPredicateWithKeyword(searchKeyword, root, builder, query);
            return builder.and(predicate.toArray(new Predicate[0]));
        };
    }
    private static List<Predicate> getPredicateWithKeyword(Map<UserMasterSpecification.UserMasterSearchKey, Object> searchKeyword, Root<UserMaster> root, CriteriaBuilder builder, CriteriaQuery<?> query) {

        List<Predicate> predicate = new ArrayList<>();

        //query.select(root.get("id")).distinct(true);

        for (UserMasterSpecification.UserMasterSearchKey key : searchKeyword.keySet()) {
            if (Objects.requireNonNull(key) == UserMasterSearchKey.userName) {     // 사용자이름
                predicate.add(builder.equal(root.get(key.name()), searchKeyword.get(key).toString()));
            }
        }

        return predicate;
    }
}
