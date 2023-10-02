package ojs.blog.ojs_back.service.dto;

public abstract class AbstractAuditingDTO<T> {

    public abstract T getId();

    public abstract void setId(T d);
}
