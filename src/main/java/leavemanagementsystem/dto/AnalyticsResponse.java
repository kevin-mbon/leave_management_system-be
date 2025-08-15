package leavemanagementsystem.dto;

import lombok.*;
import leavemanagementsystem.model.Leave;


import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AnalyticsResponse {
    public Integer totalLeaveRequests;
    public Integer ptoBalance;
    public List<Leave> teamLeaves;
}
