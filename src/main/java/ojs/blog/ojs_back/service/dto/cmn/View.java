package ojs.blog.ojs_back.service.dto.cmn;

public class View {
    public interface Required {}                     // code 성 조회, key/value 정도 조회시
    public interface Summary extends Required {}     // Summary 조회
    public interface List extends Summary {}     // List 조회
    public interface Basic extends List {}
    public interface Detail extends Basic {}    // 상세 조회

    public interface None extends Detail {}    // None

}
