package tr.com.bacompany.bahealthcrm.data.entity.work;

import lombok.Getter;

@Getter
public enum WorkStatus {
    WAITING,
    PLANNED,
    STARTED,
    PROCESSING,
    FINISHED
}
