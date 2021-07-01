<template>
  <div>
    l am index
    <button @click="close">clsdawose</button>
  </div>
</template>

<script>
export default {
  name: "Index",
  setup() {
    function close(){
        window.localStorage.removeItem("have_login");
        window.location.href = "/";
    }
    return {
        close
    }
  },
};
</script>

<style>
</style>