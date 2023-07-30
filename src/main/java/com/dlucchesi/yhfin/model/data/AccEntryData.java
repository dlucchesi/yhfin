package com.dlucchesi.yhfin.model.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter
@Setter
public class AccEntryData extends BasicEntityData {

        protected String label;
        protected String description;
        @JsonFormat(pattern="yyyy-MM-dd")
        protected Date entryDate;
        protected Double amount;
        protected String type;
        protected Long accountId;


        @Override
        public String toString() {
            return "AccEntryData{" +
                    "label='" + label + '\'' +
                    ", description='" + description + '\'' +
                    ", entryDate=" + entryDate +
                    ", amount=" + amount +
                    ", type=" + type +
                    ", AccountId=" + accountId +
                    ", id=" + id +
                    ", isDeleted=" + isDeleted +
                    ", isActive=" + isActive +
                    '}';
        }
}
