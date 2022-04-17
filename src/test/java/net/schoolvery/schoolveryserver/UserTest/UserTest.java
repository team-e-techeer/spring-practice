package net.schoolvery.schoolveryserver.UserTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.schoolvery.schoolveryserver.SpringTestSupport;
import net.schoolvery.schoolveryserver.domain.user.controller.UserController;
import net.schoolvery.schoolveryserver.domain.user.dto.request.UserCreateDto;
import net.schoolvery.schoolveryserver.domain.user.entity.User;
import net.schoolvery.schoolveryserver.domain.user.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("User 단위 테스트")
public class UserTest extends SpringTestSupport {


    @DisplayName("User Create Test")
    @Test
    void 유저생성_확인() throws Exception {
        mockMvc.perform(
                post("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"김의빈\", \"nickname\": \"Joe\", \"phone\" : 01042345," +
                                " \"student_id\": 12421,\"school\": \"성결대\",\"email\": \"asdasd\",\"password\": \"12424\"}")
        )
                .andExpect(status().isOk())
                .andDo(document("/",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestFields(
                                fieldWithPath("name").description("name"),
                                fieldWithPath("nickname").description("nickname"),
                                fieldWithPath("phone").description("phone"),
                                fieldWithPath("student_id").description("student_id"),
                                fieldWithPath("school").description("school"),
                                fieldWithPath("email").description("email"),
                                fieldWithPath("password").description("password")
                        ),
                        responseFields(
                                fieldWithPath("id").description("id")
                        ))
                );
    }

    @DisplayName("Read User")
    @Test
    public void 유저_읽기() throws Exception {
        mockMvc.perform(
                get("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andDo(
                        restDocs.document(
                                responseFields(
                                        fieldWithPath("isSuccess").description("isSuccess"),
                                        fieldWithPath("code").description("code"),
                                        fieldWithPath("message").description("message"),
                                        subsectionWithPath("result").description("result")
                                )
                        )
                );
    }

}
