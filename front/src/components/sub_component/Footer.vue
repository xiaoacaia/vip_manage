<template>
  <div class="footer">
    <div class="left"> </div>
    <div class="right">
      <p>超市会员管理系统的设计与实现</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Footer'
}
</script>

<style scoped>
  .footer {
    height: 50px;
    border-top: 1px solid #e9e9e9;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0 20px;
  }
  .right{
    margin-right: 20px;
  }
</style>