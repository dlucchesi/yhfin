package com.dlucchesi.yhfin.model.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Getter
@Setter
public class BasicEntityData implements Serializable {

        protected Long id;
        protected Boolean isActive;

        public BasicEntityData() {
        }

        public BasicEntityData(Long id, Boolean isActive) {
            this.id = id;
            this.isActive = isActive;
        }

        @Override
        public String toString() {
            return "BasicEntityData{" +
                    "id=" + id +
                    ", isActive=" + isActive +
                    '}';
        }
}
