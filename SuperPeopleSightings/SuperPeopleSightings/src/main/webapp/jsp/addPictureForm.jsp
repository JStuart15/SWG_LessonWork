
    <div class="form-group">
        <label for="picture">Upload File:</label> 
        <input type="file" id="upload-photo"
               id="picture" name="picture"/>
    </div>
    <input type="submit" value="Upload Picture"/>
    

<div class="row">
    <c:forEach var="currentPicture" items="${pictureList}">

                    <!--${currentPicture.title}<br>-->
        <img src="${pageContext.request.contextPath}/${currentPicture.filename}"
             class="img-circle col-md-1" alt="${currentPicture.title}"/> 
    </c:forEach>
</div>

