<template>
  <div>
    <div class="all-user-collections">
            
      <label class="collection-user-label" for="user-collections-dropdown">Select the Collection You Would Like to View: </label>
      <select name="user-collections-dropdown" id="dropdown-choice" class="user-collections-dropdown" v-model="selectedCollectionId">
        <option value="" disabled selected>---</option>
        <option v-for="collection in userCollections" v-bind:key="collection.collectionName" :value="collection.collectionId">{{collection.collectionName}}</option>
      </select>
      
    
      <div class="selected-collection-comics">
        <comic-book-card v-for="comic in comicsInSelectedCollection" v-bind:comic="comic" v-bind:key="comic.author"/>
      </div>

    </div>
  </div>
</template>

<script>
import ComicBookCard from "./ComicBookCard.vue"
//import ComicService from "../services/ComicService"

export default {
  name: 'comic-book-collection-user',
  props:['collection'],
  components: {
    ComicBookCard
  },
  data() {
    return {
      comics: [],
      collections: this.$store.state.collections,
      selectedCollectionId: "",
      selectedCollectionComicCount: ""
    }
  },
  computed: {
    userCollections(){
      return this.$store.state.collections.filter((collection) => {
        return collection.collectionId > 8;
      });
    },
    comicsInSelectedCollection(){
      return this.$store.state.comicsDB.filter((comic) => {
        return comic.collectionId === this.selectedCollectionId;
      })
    }
  },
  /*
  methods: {
    getComicCountByCollectionId(id){
      ComicService.getComicCountByCollectionId(id).then((response) => {
        const comicCount = response.data
        return comicCount
      })
    }
  }
  */
}
</script>

<style>
div.all-user-collections{
  border: 1px solid #fff;
  margin-bottom: 10px;
  min-height: 450px;
}

div.selected-collection-comics {
  
  display: flex;
  flex-wrap: wrap;
  margin-top: 10px;
}

div label.collection-user-label {
  font-family: monospace, serif;
  font-size: 1.5rem;
}


</style>



