<template>
  <div class="div1"></div>
</template>

<script>
// @ is an alias to /src
import axios from "axios";

export default {
  name: "test",
  components: {},
  created() {
    axios.get("/test/domain.json", { params: { id: 12 } }).then((res) => {
      console.log(res);
    });
  },
};
</script>
