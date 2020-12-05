import Vue from 'vue';
import Router from 'vue-router';
import Goi from './templates/contentPages/100Goi/goi.vue';
import Kanji from './templates/contentPages/200Kanji/kanji.vue';
import Grammar from './templates/contentPages/300Grammar/grammar.vue';
import Home from './components/Home.vue';

Vue.use(Router);

export default new Router({
    mode: "history",
    routes: [
        { path: '/', component: Home },
        { path: '/goi', component: Goi },
        { path: '/kanji', component: Kanji },
        { path: '/grammar', component: Grammar },
    ]
});