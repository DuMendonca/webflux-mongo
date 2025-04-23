package com.development.webfluxproject.adapter.mongo.document;

import com.development.webfluxproject.domain.model.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
public class UserDocument {
    @Id
    private String id;
    private final String name;

    public UserDocument(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static UserDocument fromDomain(User user) {
        return new UserDocument(user.id(), user.name());
    }

    public User toDomain() {
        return new User(id, name);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
