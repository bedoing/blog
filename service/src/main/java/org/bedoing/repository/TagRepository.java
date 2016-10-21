package org.bedoing.repository;

import org.bedoing.entity.Tag;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Ken on 2016/9/17.
 */
@Transactional
public interface TagRepository extends CrudRepository<Tag, Integer> {
    List<Tag> findByTagType(int tagType);
}
