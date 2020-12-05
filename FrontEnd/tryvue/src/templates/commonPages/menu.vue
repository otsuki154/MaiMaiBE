<template>
  <div v-if="isDisplay" class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light fix-top">
      <a class="navbar-brand" href="/">Jp</a>
      <button
        class="navbar-toggler"
        type="button"
        data-toggle="collapse"
        data-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="true"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item" v-for="item in itemMenu" :key="item.id">
            <router-link
              :to="item.url"
              class="nav-link"
              active-class="active"
              exact
              >{{ item.name }}</router-link
            >
          </li>
          
        </ul>
        <!-- <form class="form-inline my-2 my-lg-0">
          <input
            class="form-control mr-sm-2"
            type="search"
            placeholder="Search"
            aria-label="Search"
          />
          <button class="btn btn-outline-success my-2 my-sm-0" @click="search()">
            Search
          </button>
        </form> -->
      </div>
    </nav>
        <router-view></router-view>
  </div>
</template>

<script>
/*
 * Import libs and componnents
 */
import EventBus from '../../assets/js/eventBus';
export default {
  /*
   * Name of component
   */
  name: "app-menu",
  /*
   * Declare components
   */
  components: {},
  /*
   * Declare variable and set default value
   */
  data() {
    return {
      
    };
  },
  props: {
    itemMenu: {
      type: Object,
      default: null,
    },
    isDisplay: {
      type:Boolean,
      default:true,
    }
  },

  /*
   * Initialize
   */
  mounted() {},
  /*
   * Methods
   */
  methods: {
    search(){
        EventBus.$emit("haha","Message EventBus");
    }
  },
};
</script>

<style scoped>
.fix-top{
  top: 0px;
}
</style>