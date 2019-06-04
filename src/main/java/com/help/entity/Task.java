package com.help.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    /**
     * 任务id
     */
    private int taskId;
    /**
     * 任务类型
     */
    private String type;
    /**
     * 发布任务的人
     */
    private String pubUser;
    /**
     * 接受任务的人
     */
    private String subUser;
    /**
     * 任务id
     */
    private int typeId;
    /**
     * 任务状态
     * default(-1)  0未接受   1已接受
     */
    private int status;
}
