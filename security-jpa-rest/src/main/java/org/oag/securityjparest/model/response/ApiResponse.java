package org.oag.securityjparest.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@PackagePrivate
public class ApiResponse {
    String message;
    Boolean success;
}
